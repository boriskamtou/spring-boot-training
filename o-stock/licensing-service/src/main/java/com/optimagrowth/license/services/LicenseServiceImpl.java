package com.optimagrowth.license.services;

import com.optimagrowth.license.entities.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseServiceImpl implements LicenseService {
    private final MessageSource messages;

    @Autowired
    public LicenseServiceImpl(MessageSource messages) {
        this.messages = messages;
    }

    @Override
    public License getLicense(String licenseId, String organizationId, Locale locale) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setProductName("Ostock");
        license.setDescription("Software product");
        license.setLicenseType("full");
        return license;
    }

    @Override
    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage("license.create.message", null, locale), license.toString());
        }
        return responseMessage;
    }

    @Override
    public String updateLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage("license.update.message", null, locale), license.toString());
        }
        return responseMessage;
    }

    @Override
    public String deleteLicense(String licenseId, String organizationId, Locale locale) {
        String responseMessage = null;
        responseMessage = String.format(messages.getMessage("license.delete.message", null, locale), licenseId, organizationId);
        return responseMessage;
    }
}
