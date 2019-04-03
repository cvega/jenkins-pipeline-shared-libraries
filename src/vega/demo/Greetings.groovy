package vega.demo


class Greetings implements Serializable {
    def lang, name


    Greetings(String lang, String name) {
        this.lang = lang
        this.name = name ?: 'Jenkins User'
    }
    
    
    def private hello(String lang) {
        switch(lang) {
            case "english": return "Hello"; break;
            case "spanish": return "Hola"; break;
            default: return "Welcome"
        }
    }
    
    
    def private goodbye(String lang) {
        switch(lang) {
            case "english": return "Good bye"; break;
            case "spanish": return "Adiós"; break;
            default: return "Godspeed"
        }
    }
    
    
    def sayHello() {
        def greeting = hello(this.lang)
        this.cmd.echo "${greeting} ${this.name}"
    }
    
    
    def sayGoodBye() {
        def greeting = goodbye(this.lang)
        this.cmd.echo "${greeting} ${this.name}"
    }  
}
