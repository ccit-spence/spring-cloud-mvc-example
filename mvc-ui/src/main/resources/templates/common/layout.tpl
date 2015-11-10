yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en') {
    head {
        meta charset: 'utf-8'
        meta 'http-equiv': 'X-UA-Compatible', content: 'IE=edge'
        meta name: 'viewport', content: "width=device-width, initial-scale=1"
        title(pageTitle)
        link(rel:'stylesheet', href: 'webjars/bootstrap/3.3.5/css/bootstrap.min.css')
        script(src:'webjars/jquery/2.1.4/jquery.min.js'){}
        yieldUnescaped '''
        <style>
            body { padding-top: 70px; }
        </style>'''
    }
    body {
            div(class: 'container') {
                include template: 'common/fragments/application-header.tpl'
                div(class: "body-container") {
                    mainContent()
                }
            }
    }
}
