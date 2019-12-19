package com.learning.functionalprogramminggradle.AzureStorage;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.file.Path;
@Configuration
@RefreshScope
public class AzureStorageService {
    @Value("${azure.storage.container.connectionstring}")
    private String endpoint;
    public String save(MultipartFile inputFile){
        InputStream inputStream = null;
        try{
            // Read  Conn String from Config or application.properties
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(endpoint);
            CloudBlobClient cloudBlobClient = storageAccount.createCloudBlobClient();
            CloudBlobContainer cloudBlobContainer = cloudBlobClient.getContainerReference("containerReference");
            inputStream= new DataInputStream(inputFile.getInputStream());
            CloudBlockBlob cloudBlockBlob = cloudBlobContainer.getBlockBlobReference(""+inputFile.getOriginalFilename());
            // TODO: Check with Azure by sending a duplicate file.
            // Ans: Azure throws exception if file already exists.  Check with business for re-upload of duplicate file?
            // TODO: parameterize target system folder
            cloudBlockBlob.upload(inputStream,inputFile.getSize());
        } catch (Exception se){
            se.printStackTrace();
        }
        System.out.println("\t\tSuccessfully uploaded the blob.");
        String azureaccount="testing";
        return azureaccount;
    }
}