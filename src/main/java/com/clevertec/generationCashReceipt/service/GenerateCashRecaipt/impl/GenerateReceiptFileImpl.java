package com.clevertec.generationCashReceipt.service.GenerateCashRecaipt.impl;

import com.clevertec.generationCashReceipt.exceptions.IdNotFoundException;
import com.clevertec.generationCashReceipt.model.CashReceipt;
import com.clevertec.generationCashReceipt.repository.CashReceiptRepository;
import com.clevertec.generationCashReceipt.service.GenerateCashRecaipt.GenerateRecaiptFile;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Log4j2
@Service
public class GenerateReceiptFileImpl implements GenerateRecaiptFile {

    private static String nameFile;
    private static Long id;
    private final CashReceiptRepository cashReceiptRepository;

    @Autowired
    public GenerateReceiptFileImpl(CashReceiptRepository cashReceiptRepository) {
        this.cashReceiptRepository = cashReceiptRepository;
    }

    public void createFile(Long checkNumber) {
        id = checkNumber;
        nameFile = String.format("Cash receipt %d.txt", checkNumber);
        try {
            Files.createFile(Path.of(nameFile));
        } catch (IOException e) {
            log.error("Data input/output exception " + e.getMessage());
        }
    }

    private CashReceipt getModelFromDbByCheckNumber() {
        return cashReceiptRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }

    public StringBuilder builderTextReceipt() {
        CashReceipt cashReceipt = getModelFromDbByCheckNumber();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("CashReceipt\n");
        stringBuilder.append("Shop - ").append(cashReceipt.getShopInfo().getShopName()).append("\n");
        stringBuilder.append("Address - ").append(cashReceipt.getShopInfo().getAddress()).append("\n");
        stringBuilder.append("Phone number - ").append(cashReceipt.getShopInfo().getPhoneNumber()).append("\n");
        stringBuilder.append("Check number - ").append(cashReceipt.getCheckNumber()).append("\n");
        stringBuilder.append("Date - ").append(cashReceipt.getDateCreation()).append("\n");

        //TODO - Product!


        //TODO - total!

        //TODO - discond!

        return stringBuilder;

    }


    public void writeFile() {
        File file = new File(nameFile);
        try (FileWriter fileWriter = new FileWriter(file)) {

            fileWriter.write(String.valueOf(builderTextReceipt()));
        } catch (IOException e) {
            log.error("Data input/output exception " + e.getMessage());
        }
    }

    public void readFile() {
        try (FileReader fileReader = new FileReader(nameFile)) {
            while (fileReader.ready()) {
                System.out.print((char) fileReader.read());
            }
        } catch (
                FileNotFoundException e) {
            log.error(String.format("File \"%s\" does not exist\n", nameFile));
        } catch (IOException e) {
            log.error("Data input/output exception " + e.getMessage());

        }
    }

    public void deleteFile() {
        try {
            Files.delete(Path.of(nameFile));
        } catch (IOException e) {
            log.error("You can't delete a file that already doesn't exist!" + e.getMessage());
        }
    }


}
