package com.serverless.extensions


import org.mindrot.jbcrypt.BCrypt
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun String?.toHashedPassword() : String{
    return BCrypt.hashpw(this, BCrypt.gensalt())
}

infix fun String?.doesNotMatch(hashedPassword : String?) : Boolean{
    return !BCrypt.checkpw(this!!, hashedPassword)
}

fun String.toPattern() : DateTimeFormatter?{
    return DateTimeFormatter.ofPattern(this)
}
fun String.toDateTime() : LocalDateTime{
    return  LocalDateTime.parse(this, "yyyy-MM-dd'T'HH:mm:ss.SSSSSS".toPattern())
}






//fun Applicant.toLoginResponse(jwtToken : String?, detailsResponse: ApplicantDetailsResponse?,
//                         offersList : MutableList<Offer>, projectList : MutableList<Project>,
//                         educationList : MutableList<Education>, employmentList : MutableList<Employment>,
//                         interviewList : MutableList<Interview>, applicant: Applicant, links : List<Link>) : LoginResponse {
//    return LoginResponse().apply {
//        responsecode = "00"
//        responsemessage = "success"
//        details = detailsResponse
//        token  = jwtToken
//        offers = offersList
//        projects = projectList.toProjectResponse()
//        interviews =  interviewList
//        educations =  educationList
//        employments = employmentList
//    }
//}





