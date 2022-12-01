package com.optimagrowth.license.services;

import com.optimagrowth.license.entities.License;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public interface LicenseService {
    License getLicense(String licenseId, String organizationId, Locale locale);
    String createLicense(License license, String organizationId, Locale locale);
    String updateLicense(License license, String organizationId, Locale locale);
    String deleteLicense(String licenseId, String organizationId, Locale locale);
}
