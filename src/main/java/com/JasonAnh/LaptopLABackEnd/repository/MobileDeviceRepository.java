package com.JasonAnh.LaptopLABackEnd.repository;

import com.JasonAnh.LaptopLABackEnd.entity.MobileDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MobileDeviceRepository extends JpaRepository<MobileDevice, Long>,MobileDeviceRepositoryCustom {
    MobileDevice findFirstByDeviceKey(String deviceKey);
    void deleteByDeviceKey(String deviceKey);
    void deleteByFirebaseToken(String tokenFirebase);

    @Query(value = "SELECT distinct firebase_token FROM mobile_devices WHERE owner_id in ?1 and status = 1 and deleted = 0 and os_type = ?2", nativeQuery = true)
    List<String> getListFirebaseTokenByOwnerId(List<Long> ownerId, String osType);

    @Query(value = "SELECT distinct firebase_token FROM mobile_devices WHERE owner_id = ?1 and status = 1 and deleted = 0 and os_type = ?2", nativeQuery = true)
    List<String> getListFirebaseTokenForOneUser(Long ownerId, String osType);


}