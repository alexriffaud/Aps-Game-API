package com.apside.apsgame.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apside.apsgame.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

	User findByLogin(String login);
	Optional<User> findById(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO apsgame.user (mail, firstname, login, password, birthdate) " 
			+ "VALUES ( :mail , :firstname, :login, :password, :birthdate ) ", nativeQuery = true)
	void insertUser(@Param("mail") String mail,
					@Param("firstname") String firstname,
					@Param("login") String login,
					@Param("password") String password,
					@Param("birthdate") LocalDateTime birthdate);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE apsgame.user SET " 
			+ "login = :login, "
			+ "firstname = :firstname, "
			+ "mail = :mail, "
			+ "password = :password "
			+ "WHERE id = :id", nativeQuery = true)
	void updateUser(@Param("id") Long id,
					@Param("mail") String mail,
					@Param("firstname") String firstname,
					@Param("login") String login,
					@Param("password") String password);
	
	
//	"UPDATE `"+_database->getDbCommonName()+"`.`collaborators` SET "
//    " `birthdayDate` = '"+contrib->getBirthdayDate().toString("yyyy-MM-dd")+"', "
//    " `idSex` = (SELECT id FROM `"+_database->getDbCommonName()+"`.sex WHERE name LIKE '"+contrib->getSex()+"'), "
//    + selectJob +
//    " `idContract` = (SELECT id FROM `"+_database->getDbCommonName()+"`.contracts WHERE contractName LIKE '"+Contributor::toString(contrib->getContract())+"'), "
//    " `idStatus` = (SELECT id FROM `"+_database->getDbCommonName()+"`.status WHERE statusName LIKE '"+contrib->getStatus()+"'), "
//    " `position` = '"+QString::number(contrib->getPosition())+"', "
//    " `coeff` = '"+QString::number(contrib->getCoeff())+"', "
//    " `entryDate` = "+entryDate+", "
//    " `signatureDate` = "+signatureDate+", "
//    " `exitDate` = "+exitDate+", "
//    " `idIA` = "+QString::number(idIa)+" "
//    " WHERE `idContributors`= " + QString::number(contrib->getID()) + ";


}
