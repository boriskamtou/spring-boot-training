package com.optimagrowth.license.repositories;

import com.optimagrowth.license.entities.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends JpaRepository<License, String> {
     List<License> findByOrganizationId(String organizationId);
     License findByOrganizationIdAndLicenseId(String organisationId, String licenseId);
}
