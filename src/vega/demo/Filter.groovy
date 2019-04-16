package vega.demo


class Filter implements Serializable {
    private def cmd, jenkinsfile

    Filter(Object cmd, String jenkinsfile) {
        this.cmd = cmd
        this.jenkinsfile = jenkinsfile
    }


    def securityRegexp() {
        security()
    }


    def profanityRegexp() {
        profanity()
    }

    
    def private scrub(String alert) {
        cmd.echo "${alert} alert!"
        cmd.currentBuild.result = 'A
    }


    def private security() {
        if ( jenkinsfile ==~ /(?s).*credentials.*/) {
            scrub("secruity")
        }
    }

    def private profanity() {
        if ( jenkinsfile ==~ /(?s).*fightclub.*/) {
            scrub("profanity")
        }
    }
}

