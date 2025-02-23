abstract class BasePizza {
    abstract public int cost();
}

class FarmHousePizza extends BasePizza {
    public int cost() {
        return 200;
    }
}

class MargheritaPizza extends BasePizza {
    public int cost() {
        return 100;
    }
}

abstract class ToppingDecorator extends BasePizza {
    public BasePizza basePizza;

    ToppingDecorator(BasePizza pizza) {
        this.basePizza = pizza;
    }

    abstract public int cost();
}

class ExtraCheese extends ToppingDecorator {
    ExtraCheese(BasePizza pizza) {
        super(pizza);
    }

    public int cost() {
        return basePizza.cost() + 20;
    }
}

class Mushroom extends ToppingDecorator {
    Mushroom(BasePizza pizza) {
        super(pizza);
    }

    public int cost() {
        return basePizza.cost() + 10;
    }
}

public class Main {
    public static void main(String[] args) {
        BasePizza basePizza = new MargheritaPizza();
        System.out.println("Hello World " + basePizza.cost());

        BasePizza pizzaWithExtraCheese = new ExtraCheese(basePizza);
        System.out.println("Hello World with cheese " + pizzaWithExtraCheese.cost());

        BasePizza pizzaWithExtraCheeseAndMushroom = new Mushroom(pizzaWithExtraCheese);
        System.out.println("Hello World with cheese and mushroom " + pizzaWithExtraCheeseAndMushroom.cost());
    }
}
