class ComputerFacadeTestDrive {
    public static void main(String[] args) {
        /* Your subsystems */
        Processor processor = new Processor();
        Monitor monitor = new Monitor();
        Keyboard keyboard = new Keyboard();

        ComputerFacade computerFacade = new ComputerFacade(processor, monitor, keyboard);

        computerFacade.turnOnComputer();
        computerFacade.turnOffComputer();
    }
}

class ComputerFacade {
    /* Your subsystems */
    Processor processor;
    Monitor monitor;
    Keyboard keyboard;

    public ComputerFacade(Processor processor, Monitor monitor, Keyboard keyboard) {
        this.processor = processor;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public void turnOnComputer() {
        /* Write your code here */
        processor.on();
        monitor.on();
        keyboard.on();
    }

    public void turnOffComputer() {
        /* Write your code here */
        keyboard.off();
        monitor.off();
        processor.off();
    }
}

class Processor {
    /* Your subsystem description */

    public void on() {
        /* Write your code here */
        System.out.println("Processor on");
    }

    public void off() {
        /* Write your code here */
        System.out.println("Processor off");
    }
}

class Monitor {
    /* Your subsystem description */

    public void on() {
        /* Write your code here */
        System.out.println("Monitor on");
    }

    public void off() {
        /* Write your code here */
        System.out.println("Monitor off");
    }
}

class Keyboard {
    /* Your subsystem description */

    public void on() {
        /* Write your code here */
        System.out.println("Keyboard on");
        turnOnBacklight();
    }

    public void off() {
        /* Write your code here */
        System.out.println("Keyboard off");
        turnOffBacklight();
    }

    private void turnOnBacklight() {
        /* Write your code here */
        System.out.println("Backlight is turned on");
    }

    private void turnOffBacklight() {
        /* Write your code here */
        System.out.println("Backlight is turned off");
    }
}