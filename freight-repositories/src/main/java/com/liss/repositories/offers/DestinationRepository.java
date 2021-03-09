package com.liss.repositories.offers;

import com.liss.entities.offers.DestinationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<DestinationEntity, String> {


    /**@author Patrick
     *
     * get all destination freight
     * */

    @Query("SELECT d FROM Destination d WHERE isDeleted = false ORDER BY createdAt DESC")
    public Page<DestinationEntity>findAllDestinationFreight(Pageable pageable);

    /** get all destination vehicle **/

    @Query("SELECT d FROM Destination  d WHERE isDeleted = false ORDER BY createdAt DESC ")
    public Page<DestinationEntity> getAllDestinationVehicle(Pageable pageable);

    /** les destinations d'un freight **/

    @Query("SELECT d FROM Destination  d WHERE isDeleted = false AND freight.id = :freight ORDER BY createdAt DESC")
    public Page<DestinationEntity>getAllDestinationFreight(Pageable page, @Param("freight") String freight );

    /** get one destination  **/
    @Query("SELECT d FROM Destination d WHERE id = :id")
    public DestinationEntity getDestinationById(@Param("id") String id);
}
