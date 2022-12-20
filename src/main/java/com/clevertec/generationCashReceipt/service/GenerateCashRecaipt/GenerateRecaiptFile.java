package com.clevertec.generationCashReceipt.service.GenerateCashRecaipt;

import org.springframework.stereotype.Service;

@Service
public interface GenerateRecaiptFile {

    void createFile(Long checkNumber);

    void writeFile();

    void readFile();

    void deleteFile();

    StringBuilder builderTextReceipt();
}
