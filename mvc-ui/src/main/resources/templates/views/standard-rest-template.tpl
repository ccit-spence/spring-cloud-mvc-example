layout 'common/layout.tpl', true,
pageTitle: title,
mainContent: contents {
    h1 'Eureka Aware RestTemplate'
    p 'Basic implementation of the Eureka aware RestTemplate.'
    hr()
    h2 'List of smart people.'
    ul() {
        instructors.each { instructor ->
            li() yield "$instructor.firstName" + ' ' + "$instructor.lastName"
        }
    }
}
