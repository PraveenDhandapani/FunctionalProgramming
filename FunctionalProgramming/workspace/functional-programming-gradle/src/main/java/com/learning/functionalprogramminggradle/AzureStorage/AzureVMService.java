package com.learning.functionalprogramminggradle.AzureStorage;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import net.schmizz.sshj.xfer.scp.SCPFileTransfer;
import net.schmizz.sshj.xfer.scp.SCPUploadClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
@Configuration
public class AzureVMService {
    public String save(MultipartFile inputFile) {
        try {
            SSHClient client = new SSHClient();
            client.addHostKeyVerifier(new PromiscuousVerifier());
            client.connect("sumoprevm1.eastus.cloudapp.azure.com");
            client.authPassword("pdhanda2", "Zuoraqa_test");
            SFTPClient sftpClient = client.newSFTPClient();
            SCPFileTransfer scpFileTransfer = client.newSCPFileTransfer();
            SCPUploadClient scpUploadClient = scpFileTransfer.newSCPUploadClient();
            Sink sink = new Sink(inputFile.getOriginalFilename(), inputFile.getSize(), inputFile.getInputStream());
            String remoteDir = "test/";
            scpUploadClient.copy(sink, remoteDir);
            System.out.println("Connected to SFTP");
            System.out.println("picked the file");
//            sftpClient.put(sink, remoteDir);
            sftpClient.close();
            client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
