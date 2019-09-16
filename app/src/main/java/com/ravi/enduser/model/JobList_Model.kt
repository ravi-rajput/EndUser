package com.ravi.enduser.model

class JobList_Model {

    var profile=""
    var company_name=""
    var contact_no =""
    var datetime=""

    constructor(profile: String, company_name: String, contact_no: String, datetime: String) {
        this.profile = profile
        this.company_name = company_name
        this.contact_no = contact_no
        this.datetime = datetime
    }
}