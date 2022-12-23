package com.optimagrowth.license.services;

import com.optimagrowth.license.config.ServiceConfig;
import com.optimagrowth.license.entities.License;
import com.optimagrowth.license.repositories.LicenseRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;


import java.util.Locale;
import java.util.UUID;

@Service
public class LicenseServiceImpl implements LicenseService {
    private final MessageSource messages;
    private final LicenseRepository licenceRepository;
    private final ServiceConfig config;
    public LicenseServiceImpl(MessageSource messages, LicenseRepository licenceRepository, ServiceConfig config) {
        this.messages = messages;
        this.licenceRepository = licenceRepository;
        this.config = config;
    }


    @Override
    public License getLicense(String licenseId, String organizationId, Locale locale) {
        License license = licenceRepository.findByOrganizationIdAndLicenseId(licenseId, organizationId);
        if (license == null) {
            throw new IllegalArgumentException(String.format(
                    messages.getMessage("license.search.error.message", null, locale),
                    licenseId, organizationId));
        }
        return license.withComment(config.getProperty());
    }

    @Override
    public License createLicense(License license, String organizationId, Locale locale) {
        license.setLicenseId(UUID.randomUUID().toString());
        licenceRepository.save(license);
        return license.withComment(config.getProperty());
    }

    @Override
    public License updateLicense(License license, String organizationId, Locale locale) {
        licenceRepository.save(license);
        return license.withComment(config.getProperty());
    }

    @Override
    public String deleteLicense(String licenseId, String organizationId, Locale locale) {
        String responseMessage = null;
        License license = new License();
        license.setLicenseId(licenseId);
        licenceRepository.delete(license);
        responseMessage = String.format(messages.getMessage(
                "license.delete.message", null, locale), licenseId);
        return responseMessage;
    }
}
