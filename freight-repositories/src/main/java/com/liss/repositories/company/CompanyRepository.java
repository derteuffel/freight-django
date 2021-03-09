package com.liss.repositories.company;

import com.liss.entities.compagny.CompanyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {

    /** recherche a parti de son ID **/
    @Query("FROM Company com WHERE isDeleted = false AND com.id = :companyID")
    public CompanyEntity findByID(@Param("companyID")String companyID);


    /**@author Issofa
     * récupération des Commissionnaires
     */
    //c where c.enable=true
    @Query("FROM Company c where c.enable = :etat AND ( "
            + "TRIM(UPPER(c.name)) LIKE TRIM(UPPER(CONCAT('%',:query,'%'))) OR "
            + "TRIM(UPPER(c.country)) LIKE TRIM(UPPER(CONCAT('%',:query,'%'))) OR "
            + "TRIM(UPPER(c.address)) LIKE TRIM(UPPER(CONCAT('%',:query,'%'))) OR "
            + "TRIM(UPPER(c.town)) LIKE TRIM(UPPER(CONCAT('%',:query,'%'))) OR "
            + "TRIM(UPPER(c.postalCode)) LIKE TRIM(UPPER(CONCAT('%',:query,'%'))) ) ")
    public Page<CompanyEntity> findAllCompany(@Param("query")String query, @Param("etat")boolean etat, Pageable pageablerequest);

    /** @author jaudrx
     *
     * @param query
     * @param etat
     * @param companyType
     * @param pageablerequest
     * @return
     */

    @Query("FROM Company c where c.enable = :etat AND c.companyType = :type  AND ( "
            + "TRIM(UPPER(c.name)) LIKE TRIM(UPPER(CONCAT('%',:query,'%'))) OR "
            + "TRIM(UPPER(c.country)) LIKE TRIM(UPPER(CONCAT('%',:query,'%'))) OR "
            + "TRIM(UPPER(c.address)) LIKE TRIM(UPPER(CONCAT('%',:query,'%'))) OR "
            + "TRIM(UPPER(c.town)) LIKE TRIM(UPPER(CONCAT('%',:query,'%'))) OR "
            + "TRIM(UPPER(c.postalCode)) LIKE TRIM(UPPER(CONCAT('%',:query,'%'))) ) ")
    public Page<CompanyEntity> findAllSpecificCompany(@Param("query")String query, @Param("etat")boolean etat, @Param("type")String type, Pageable pageablerequest);




    /**@author Issofa
     * compte le nombre total des commissionnaires
     */
    @Query("select COUNT(c) From Company c ")//where c.enable=true
    public Long totalElements();

    /**@author Issofa
     * compte le nombre des commissionnaires actifs
     */
    @Query("select COUNT(c) From Company c where c.enable=true")//
    public Long totalElementsActif();

    /**@author Issofa
     * compte le nombre des commissionnaires désactivé
     */
    @Query("select COUNT(c) From Company c where c.enable=false ")
    public Long totalElementDeleted();


    /**@author Patrick
     * get All company
     * */

    @Query("SELECT c FROM Company c WHERE isDeleted = false "
            + "ORDER BY name ASC")
    public Page<CompanyEntity>findAllCompany(Pageable page);

    @Query("SELECT c FROM Company c WHERE isDeleted = false AND  UPPER(vat) = UPPER(:vat)")
    public CompanyEntity findByVat(@Param("vat") String vat);

    @Query("SELECT c FROM Company c WHERE isDeleted = false AND  UPPER(name) = UPPER(:name)")
    public CompanyEntity findByName(@Param("name") String name);

    /** get All Company by param**/
    @Query("SELECT c FROM Company c WHERE isDeleted = false AND UPPER(name) LIKE CONCAT(UPPER(:name), '%') ORDER BY name ASC")
    public Page<CompanyEntity> getAllCompanyByPram(Pageable page, @Param("name") String name);

}
