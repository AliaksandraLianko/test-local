package com.company.nominator;


import com.company.award.Award;
import com.company.exceptions.SmallAwardAmountException;
import com.company.nominee.Nominee;
import com.company.person.Person;

public class Nominator extends Person {
    static {
        System.out.println("Static init block for Nominator");
    }

    private int numberOfGivenAwards;

    public Nominator(String name) {
        super(name);
    }

    public Nominator(String name, int numberOfGivenAwards) {
        super(name);
        this.numberOfGivenAwards = numberOfGivenAwards;
    }

    public Nominator(String name, Integer awardQuantityLimit, float awardAmountLimit, int numberOfGivenAwards) {
        super(name, awardQuantityLimit, awardAmountLimit);
        this.numberOfGivenAwards = numberOfGivenAwards;
    }

    @Override
    public void receiveAward(Award award) throws SmallAwardAmountException{
        if (award.getValue() >= 0) {
            if (award.getSoli() == 0.0) {
                System.out.println("Award value calculated without soli: " + award.getValue());
            } else {
                System.out.println("Error. Soli factor cannot be calculated for nominator" );
            }
        } else throw new SmallAwardAmountException("Nominator cannot give award with negative value");
    }

    @Override
    public void createYosAward(Award award, Person nominee) {
          if (award.getValue() >=100) {
            super.createYosAward(award, nominee);
            System.out.println("YOS award is generated automatically based on hire date");
        } else {
            System.out.println("YOS award is not generated due to low award value");
        }
    }
}
