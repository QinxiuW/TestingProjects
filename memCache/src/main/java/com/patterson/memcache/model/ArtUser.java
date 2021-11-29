/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.patterson.memcache.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ArtUser model.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
@EqualsAndHashCode
@Table(name = "ART_USERS")
public class ArtUser implements Serializable {

  private static final long serialVersionUID = -399212772391287379L;

  @Id
  @Column(name = "NIDUSER")
  @GeneratedValue(generator = "user-sequence", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "user-sequence", sequenceName = "S_ART_USERS", allocationSize = 1)
  private int userId;

  @Column(name = "VNAME")

  private String name;

  @Column(name = "VEMAIL")
  private String email;

  @Column(name = "VPASSWORD")
  @JsonIgnore
  private String password;

}
