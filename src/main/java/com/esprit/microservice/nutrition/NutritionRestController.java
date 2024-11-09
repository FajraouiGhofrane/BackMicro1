package com.esprit.microservice.nutrition;

import lombok.AllArgsConstructor;
//import org.keycloak.KeycloakPrincipal;
//import org.keycloak.KeycloakSecurityContext;
//import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/nutrition")
@CrossOrigin(origins = "http://localhost:4200")
public class NutritionRestController {

    INutritionService nutritionService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/retrieve-all-nutritions")
    public List<Nutrition> getNutritions() {
        List<Nutrition> listNutritions = nutritionService.getAllNutritions();
        return listNutritions;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/retrieve-nutrition/{nutrition-id}")
    public Nutrition retrieveNutrition(@PathVariable("nutrition-id") Long ntId) {
        Nutrition nutrition  = nutritionService.retrieveNutrition(ntId);
        return nutrition;
    }
//    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping(value="/user")
//    @ResponseStatus(HttpStatus.CREATED)
//    // http://localhost:8089/tpfoyer/etudiant/add-etudiant
//    @PostMapping("/add-nutrition")
//    public ResponseEntity<Nutrition> addNutrition(@RequestBody Nutrition nt, KeycloakAuthenticationToken auth) {
//        KeycloakPrincipal<KeycloakSecurityContext> principal=(KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
//        KeycloakSecurityContext context=principal.getKeycloakSecurityContext();
//        boolean hasUserRole=context.getToken().getRealmAccess().isUserInRole("user1");
//        if(hasUserRole){
//        return new ResponseEntity<>(nutritionService.addNutrition(nt),HttpStatus.OK);
//        }else {
//        return new ResponseEntity<>(HttpStatus.FORBIDDEN);}
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-nutrition")
    public ResponseEntity<Nutrition> addNutrition(@RequestBody Nutrition nt) {
        // Ajoutez simplement l'élément de type Nutrition sans vérification de rôle
        return new ResponseEntity<>(nutritionService.addNutrition(nt), HttpStatus.OK);
    }


//    @CrossOrigin(origins = "http://localhost:4200")
//    @DeleteMapping(value = "/admin/{nutrition-id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<String> removeNutrition(@PathVariable("nutrition-id") Long ntId, KeycloakAuthenticationToken auth) {
//        KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
//        KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
//        boolean hasUserRole = context.getToken().getRealmAccess().isUserInRole("user1");
//
//        if (hasUserRole) {
//            nutritionService.removeNutrition(ntId); // Call the service without expecting a return value
//            return new ResponseEntity<>("Nutrition item removed successfully", HttpStatus.OK); // Return a custom success message
//        } else {
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN); // Forbidden if user doesn't have the role
//        }
//    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/remove-nutrition/{nutrition-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> removeNutrition(@PathVariable("nutrition-id") Long ntId) {
        // Appel au service pour supprimer l'élément Nutrition sans vérification de rôle
        nutritionService.removeNutrition(ntId);
        return new ResponseEntity<>("Nutrition item removed successfully", HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    // http://localhost:8089/tpfoyer/etudiant/modify-etudiant
    @PutMapping("/modify-nutrition/{id}")
    public Nutrition modifyNutrition(@PathVariable Long id, @RequestBody Nutrition nt) {
        return nutritionService.modifyNutrition(id, nt);

    }

}
