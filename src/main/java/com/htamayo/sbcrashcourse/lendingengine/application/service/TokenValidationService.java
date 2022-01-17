package com.htamayo.sbcrashcourse.lendingengine.application.service;

import com.htamayo.sbcrashcourse.lendingengine.domain.exception.UserNotFoundException;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.AppUser;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class TokenValidationService {
    private final AppUserRepository appUserRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final String securityContextBaseUrl;

    @Autowired
    public TokenValidationService(final AppUserRepository appUserRepository, @Value("${security.baseurl}") final String securityContextBaseUrl) {
        this.appUserRepository = appUserRepository;
        this.securityContextBaseUrl = securityContextBaseUrl;
    }

    public AppUser validateTokenAndGetUser(final String token){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, token);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<String> response = restTemplate
                .exchange(securityContextBaseUrl + "/user/validate", HttpMethod.POST, httpEntity, String.class);

        if(response.getStatusCode().equals(HttpStatus.OK)){
            return appUserRepository.findById(Long.valueOf(response.getBody()))
                    .orElseThrow(() -> new UserNotFoundException(Long.valueOf(response.getBody())));
        }

        throw new RuntimeException("Invalid token");


    }
}
