package br.com.robson.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "salvadadosxml", schema = "public", catalog = "basetesterob")
public class SalvadadosxmlEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "tagsxml")
    private String tagsxml;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagsxml() {
        return tagsxml;
    }

    public void setTagsxml(String tagsxml) {
        this.tagsxml = tagsxml;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalvadadosxmlEntity that = (SalvadadosxmlEntity) o;

        if (id != that.id) return false;
        if (!Objects.equals(tagsxml, that.tagsxml)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tagsxml != null ? tagsxml.hashCode() : 0);
        return result;
    }
}
