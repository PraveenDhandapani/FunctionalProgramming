package com.learning.functionalprogramminggradle.AzureStorage;

import com.ford.sumo.dashboard.OrderInfoService;
import com.ford.sumo.dashboard.support.DashboardValidator;
import com.ford.sumo.repository.FulfillmentRepository;
import com.ford.sumo.service.AzureStorageService;
//import com.ford.sumo.service.AzureVMService;
import com.ford.sumo.service.AzureVMService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.mail.Multipart;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class AzureStorageController {

    private final AzureStorageService azureStorageService;
    private final AzureVMService azureVMService;
    @PostMapping(path="/fileUpload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam(value="file") List<MultipartFile> inputFile){
        if(inputFile.isEmpty()){
            return "No file to be upload";
        }else{
            try {
                for (MultipartFile input:inputFile) {
                    System.out.println("inputFile. = " + input.getName());
                    System.out.println("inputFile.getBytes = " + input.getBytes());
                    //azureStorageService.save(inputFile);
                    azureVMService.save(input);
                /*Path filePath = Paths.get("./");
                OutputStream os = Files.newOutputStream(filePath);
                os.write(inputFile.getBytes());*/
                }
            }catch(IOException e){
                System.out.println("e.getMessage() = " + e.getMessage());
            }
            return "Received File >>";
            //The field file exceeds its maximum permitted size of 1048576 bytes.
        }
    }

}


