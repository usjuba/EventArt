package com.tirali.eventart.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToOne;
import com.tirali.eventart.model.User;
import javax.persistence.CascadeType;
import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;
import com.tirali.eventart.model.Event;
import javax.persistence.OneToMany;

@Entity
public class Event implements java.io.Serializable
{

   @Id
   private @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   Long id = null;
   @Version
   private @Column(name = "version")
   int version = 0;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((Event) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   @Column
   private String name;

   public String getName()
   {
      return this.name;
   }

   public void setName(final String name)
   {
      this.name = name;
   }

   @Column
   private String type;

   public String getType()
   {
      return this.type;
   }

   public void setType(final String type)
   {
      this.type = type;
   }

   @Column
   private String description;

   public String getDescription()
   {
      return this.description;
   }

   public void setDescription(final String description)
   {
      this.description = description;
   }

   @Column
   private String theme;

   public String getTheme()
   {
      return this.theme;
   }

   public void setTheme(final String theme)
   {
      this.theme = theme;
   }

   private @Temporal(TemporalType.DATE)
   Date startDate;

   public Date getStartDate()
   {
      return this.startDate;
   }

   public void setStartDate(final Date startDate)
   {
      this.startDate = startDate;
   }

   private @Temporal(TemporalType.DATE)
   Date endDate;

   public Date getEndDate()
   {
      return this.endDate;
   }

   public void setEndDate(final Date endDate)
   {
      this.endDate = endDate;
   }

   @Column
   private String place;

   public String getPlace()
   {
      return this.place;
   }

   public void setPlace(final String place)
   {
      this.place = place;
   }

   public String toString()
   {
      String result = "";
      if (name != null && !name.trim().isEmpty())
         result += name;
      if (type != null && !type.trim().isEmpty())
         result += " " + type;
      if (description != null && !description.trim().isEmpty())
         result += " " + description;
      if (theme != null && !theme.trim().isEmpty())
         result += " " + theme;
      if (place != null && !place.trim().isEmpty())
         result += " " + place;
      return result;
   }

   @OneToOne(cascade = CascadeType.ALL)
   @MapsId
   private User owner;

   public User getOwner()
   {
      return this.owner;
   }

   public void setOwner(final User owner)
   {
      this.owner = owner;
   }

   public void newOwner(final User owner)
   {
      this.owner = new User();
   }

   public void newUser()
   {
      this.owner = new User();
   }

}