
package restaurantsystem.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurantsystem.frontend.Update;

/**
 *
 * @author
 */
public class ReserveBackend {

    public ReserveBackend() {
    }

    public List<reserve> getAll() {
        List<reserve> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("DATABASE/reservedatabase.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                reserve item = new reserve(itemInfo[0], itemInfo[1],
                        itemInfo[2], itemInfo[3], itemInfo[4]);

                items.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReserveBackend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }

    public reserve getItemByIndex(int index) {
        List<reserve> listOfItem = getAll();

        if (listOfItem.size() >= index) {
            return listOfItem.get(index - 1);
        }

        return null;
    }

    public void create(reserve item) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("DATABASE/reservedatabase.txt", true))) {
            pw.println(item.getName() + "," + item.getResnum() + "," + item.getDaT() + "," + item.getAdult() + "," + item.getChild());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReserveBackend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized boolean delete(String name) {

        List<reserve> itemList = getAll();

        int indexToBeDeleted = -1;
        // find the item to be deleted
        for (int i = 0; i < itemList.size(); i++) {
            reserve item = itemList.get(i);

            if (item.getName().equalsIgnoreCase(name)) {
                indexToBeDeleted = i;
            }
        }

        if (indexToBeDeleted == -1) {
            return false;
        }
        itemList.remove(indexToBeDeleted);

        try {
            // Delete the entire file
            Files.delete(Paths.get("DATABASE/reservedatabase.txt"));
        } catch (IOException ex) {
            Logger.getLogger(ReserveBackend.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Create a new file and write new data into the file
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("DATABASE/reservedatabase.txt"))) {
            itemList.forEach(item -> {
                pw.println(item.getName() + "," + item.getResnum() + "," + item.getDaT() + "," + item.getAdult() + "," + item.getChild());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReserveBackend.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public synchronized boolean update(String srcName, reserve updatedItem) {
        List<reserve> itemList = new ArrayList<>();

        // Read all the items
        try (Scanner scanner = new Scanner(new FileInputStream("DATABASE/reservedatabase.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                reserve item = new reserve(itemInfo[0], itemInfo[1],
                        itemInfo[2], itemInfo[3], itemInfo[4]);
                itemList.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }

        int itemIndexToUpdate = -1;

        for (int i = 0; i < itemList.size(); i++) {
            reserve item = itemList.get(i);

            if (item.getName().equalsIgnoreCase(srcName)) {
                itemIndexToUpdate = i;
            }
        }

        if (itemIndexToUpdate == -1) {
            return false;
        }

        itemList.set(itemIndexToUpdate, updatedItem);

        try {
            Files.delete(Paths.get("DATABASE/reservedatabase.txt"));
        } catch (IOException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("DATABASE/reservedatabase.txt"))) {
            itemList.forEach(item -> {
                pw.println(item.getName() + "," + item.getResnum() + "," + item.getDaT() + "," + item.getAdult() + "," + item.getChild());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public synchronized void reduceItemQuantityByItemName(String itemName, int reduceNumber) {
        List<reserve> itemList = getAll();

        for (int i = 0; i < itemList.size(); i++) {

            reserve item = itemList.get(i);

            if (item.getName().equalsIgnoreCase(itemName)) {
                itemList.set(i, item);
            }
        }

        try {
            Files.delete(Paths.get("DATABASE/reservedatabase.txt"));
        } catch (IOException ex) {
            Logger.getLogger(ReserveBackend.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/reservedatabase.txt"))) {
            itemList.forEach(item -> {
                pw.println(item.getName() + "," + item.getResnum() + "," + item.getDaT() + "," + item.getAdult() + "," + item.getChild());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReserveBackend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
