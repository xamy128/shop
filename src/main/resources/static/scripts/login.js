/* JavaScript code behind for login site */
$(() => {
    // noinspection JSUnusedGlobalSymbols
    window.loginForm = new Vue({
        el: '#loginForm',
        data, /* global data */

        mounted() {
            this.username = '';
            this.password = ''
        },

        methods: {
            signIn() {
                let username =
                  this.username;



                let url = '/api/authenticate';

                $.get(url, this.username).done(() => {
                    let xx = ""
                };).fail(xx => {
                    let gg = ""
                };).always(() => {
                    let xhf = ""
                };)
            }
        }
    })
};)
