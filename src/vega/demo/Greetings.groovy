package vega.demo


class Greetings implements Serializable {
    private def cmd, lang, name

    Greetings(cmd, String lang, String name) {
        this.cmd  = cmd
        this.lang = lang
        this.name = name ?: 'Jenkins User'
    }


    def sayHello() {
        say(hello(this.lang))
    }
    

    def sayGoodbye() {
        say(goodbye(this.lang))
    }  

    
    def private say(String greeting) {
        this.cmd.echo "${greeting} ${this.name}"
    }
    
    
    def private hello(String lang) {
        switch(lang) {
            case "chinese": return "你好"; break;
            case "english": return "Hello"; break;
            case "hindi": return "नमस्ते"; break;
            case "japanese": return "こんにちは"; break;
            case "spanish": return "Hola"; break;
            default: return "Welcome";
        }
    }
    
    
    def private goodbye(String lang) {
        switch(lang) {
            case "chinese": return "再见"; break;
            case "english": return "Good bye"; break;
            case "hindi": return "अलविदा"; break;
            case "japanese": return "さようなら"; break;
            case "spanish": return "Adiós"; break;
            default: return "Godspeed";
        }
    }
}
