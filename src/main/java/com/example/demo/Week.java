package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String day;

    private String time;



    @OneToOne(mappedBy = "week")
    private Fruit fruit;

//    @OneToMany(mappedBy = "week", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    //public Set<Week> weeks;
//    public Set<Fruit> fruits;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

//    public Set<Week> getWeeks() {
//        return weeks;
//    }
//
//    public void setWeeks(Set<Week> weeks) {
//        this.weeks = weeks;
//    }

    //    public Set<Fruit> getFruits() {
//        return fruits;
//    }
//
//    public void setFruits(Set<Fruit> fruits) {
//        this.fruits = fruits;
//    }


    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }
}
