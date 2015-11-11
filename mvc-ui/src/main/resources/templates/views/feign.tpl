layout 'common/layout.tpl', true,
pageTitle: title,
mainContent: contents {
    h1 'Feign Client'
    p 'An example of Feign'
    hr()
    h2 'Feign Client Results'
    ul() {
        instructors.each { instructor ->
            li() yield "$instructor.firstName" + ' ' + "$instructor.lastName"
        }
    }
}
