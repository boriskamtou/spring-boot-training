package com.optimagrowth.license.controllers;

import com.optimagrowth.license.entities.License;
import com.optimagrowth.license.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/v1/organization/{organizationId}/license")
public class LicenseController {
    private final LicenseService licenseService;

    @Autowired
    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping("/{licenseId}")
    public ResponseEntity<License> getLicense(
            @PathVariable("licenseId") String licenseId,
            @PathVariable("organizationId") String organizationId,
            @RequestHeader(value = "Accept-Language",required = false) Locale locale) {
        License license = licenseService.getLicense(licenseId, organizationId, locale);
        license.add(
                linkTo(methodOn(LicenseController.class).getLicense(licenseId, organizationId, locale)).withSelfRel(),
                linkTo(methodOn(LicenseController.class).createLicense(null, organizationId, locale)).withRel("createLicense"),
                linkTo(methodOn(LicenseController.class).updateLicense(null, organizationId, locale)).withRel("updateLicense"),
                linkTo(methodOn(LicenseController.class).deleteLicense(licenseId, organizationId, locale)).withRel("deleteLicense")
        );
        return ResponseEntity.ok(license);
    }

    @PutMapping
    public ResponseEntity<String> updateLicense(
            @RequestBody License request,
            @PathVariable("organizationId") String organizationId,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(licenseService.updateLicense(request, organizationId, locale));
    }

    @PostMapping
    public ResponseEntity<String> createLicense(@RequestBody License request,
                                                @PathVariable("organizationId") String organizationId,
                                                @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(licenseService.createLicense(request, organizationId, locale));
    }

    @DeleteMapping("/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable("licenseId") String licenseId,
                                                @PathVariable("organizationId") String organizationId,
                                                @RequestHeader(value = "Accept-Language", required = false) Locale locale
                                                ) {
        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId, locale));

    }
}
