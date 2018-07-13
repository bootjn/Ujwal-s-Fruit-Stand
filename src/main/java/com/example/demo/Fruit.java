package com.example.demo;

import javax.persistence.*;


@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fruitname;

    private String pictureUrl;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "week_id")
    private Week week;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "week_id")
//    private Week week;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFruitname() {
        return fruitname;
    }

    public void setFruitname(String fruitname) {
        this.fruitname = fruitname;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
