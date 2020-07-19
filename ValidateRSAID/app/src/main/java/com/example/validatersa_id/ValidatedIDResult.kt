package com.example.validatersa_id

/*class ValidatedIDResult {
    private fun validateID(id: String): Boolean{
        var count = 0
        var storeString = ""
        var storeNumber = 0
        for (i in id){
            if (count % 2 == 1){
                storeString = id.substring(count, count + 1)
                storeNumber = storeString.toInt()
                storeNumber *= 2
                if(storeNumber.toString().length == 2){
                    val charOne = storeNumber.toString().substring(0, 1)
                    val charTwo = storeNumber.toString().substring(1, 2)
                    sum += charOne.toInt() + charTwo.toInt()
                }else {
                    sum += storeNumber
                }
            } else {
                storeString = id.substring(count, count + 1)
                storeNumber = storeString.toInt()
                sum += storeNumber
            }
            count += 1
        }

        return sum % 10 == 0


    }
}*/