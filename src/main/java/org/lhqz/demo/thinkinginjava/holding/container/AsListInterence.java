package org.lhqz.demo.thinkinginjava.holding.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

public class AsListInterence {

    public static void main(String[] args) {
        List<Snow> show1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
        List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
        List<Snow> show3 = new ArrayList<>();
        Collections.addAll(show3, new Light(), new Heavy());

        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
    }

}
