package com.example.receptzoeken.utils

enum class type {
    main_course,
    side_dish,
    dessert,
    appetizer,
    salad,
    bread,
    breakfast,
    soup,
    beverage,
    sauce,
    drink;



    override fun toString():String {
        return this.name.replace('_','+')
    }
}

enum class diet {
    pescetarian, lacto_vegetarian, ovo_vegetarian, vegan, vegetarian;
    override fun toString():String {
        return this.name.replace('_','+')
    }
}

enum class cuisine {
    african,
    chinese,
    japanese,
    korean,
    vietnamese,
    thai,
    indian,
    british,
    irish,
    french,
    italian,
    mexican,
    spanish,
    middle_eastern,
    jewish,
    american,
    cajun,
    southern,
    greek,
    german,
    nordic,
    eastern_european,
    caribbean,
    latin_american;


    override fun toString():String {
        return this.name.replace('_','+')
    }
}

enum class intolerances{
    dairy, egg, gluten, peanut, sesame, seafood, shellfish, soy, sulfite, tree_nut, wheat;

    override fun toString():String {
        return this.name.replace('_','+')
    }
}