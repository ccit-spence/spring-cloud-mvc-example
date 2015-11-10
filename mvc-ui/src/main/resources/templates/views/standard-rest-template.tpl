layout 'common/layout.tpl', true,
pageTitle: title,
mainContent: contents {
    h1 'Rest Template'
    p 'Below are 2 versions of results.  One with an Autowired RestTemplate and one with a customer RestTemplate.'
    hr()
    h2 '@Autowired RestTemplate'
    ul() {
        instructors.each { instructor ->
            li() yield "$customInstructor.firstName" + ' ' + "$customInstructor.lastName"
        }
    }
    h2 'Custom RestTemplate'
    ul() {
        customInstructors.each { customInstructor ->
            li() yield "$customInstructor.firstName" + ' ' + "$customInstructor.lastName"
        }
    }
}
