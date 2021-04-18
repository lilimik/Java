package ru.itis.springbootsemester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootsemester.security.details.UserDetailsImpl;
import ru.itis.springbootsemester.services.FileStorageService;
import ru.itis.springbootsemester.services.UsersService;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FilesController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private UsersService usersService;

//    @PreAuthorize("isAuthenticated()")
    @PostMapping("/files")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        String filePath = fileStorageService.saveFile(file);

        String email = userDetails.getUsername();
        usersService.updateAvatarStorageName(email, filePath);

        return ResponseEntity.ok()
                .body(filePath);
    }

    @PermitAll
    @GetMapping("/files/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileName, HttpServletResponse response) {
        fileStorageService.writeFileToResponse(fileName, response);
    }

}
