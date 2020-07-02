class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  
}

class Dog extends Animal {
  
}
class OuterClass {
    int x = 10;
  
    class InnerClass {
      int y = 5;
    }
  }

class MyMainClass {
  public static void main(String[] args) {
    
    Animal myPig = new Pig();
    Animal myDog = new Dog();
        
    OuterClass myOuter = new OuterClass();
      OuterClass.InnerClass myInner = myOuter.new InnerClass();
      System.out.println(myInner.y + myOuter.x);
    myPig.animalSound();
    myDog.animalSound();
  }
}
