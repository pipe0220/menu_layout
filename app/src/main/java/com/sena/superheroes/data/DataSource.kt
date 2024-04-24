package com.sena.superheroes.data

import com.sena.superheroes.model.Superheroe

class DataSource() {
    fun getSuperHeroes():MutableList<Superheroe> {
        var superheroes: MutableList<Superheroe> = mutableListOf()
        superheroes.add(Superheroe("Batman", "DC", "Bruce Wayne", "https://www.superherodb.com/pictures2/portraits/10/100/639.jpg"))
        superheroes.add(Superheroe("Spiderman", "Marvel", "Tobey Maguire", "https://static.wikia.nocookie.net/ficcion-sin-limites/images/6/6b/Spidey.png/revision/latest/scale-to-width-down/375?cb=20210226124716&path-prefix=es"))
        superheroes.add(Superheroe("Superman", "DC", "Clark Kent", "https://upload.wikimedia.org/wikipedia/en/3/35/Supermanflying.png"))
        superheroes.add(Superheroe("Ironman", "Marvel", "Tony Stark", "https://www.superherodb.com/pictures2/portraits/10/100/85.jpg"))
        superheroes.add(Superheroe("Thor", "Marvel", "Thor Odinson", "https://www.superherodb.com/pictures2/portraits/10/100/140.jpg"))
        superheroes.add(Superheroe("Hulk", "Marvel", "Bruce Banner", "https://w7.pngwing.com/pngs/347/781/png-transparent-hulk-marvel-heroes-2016-black-widow-clint-barton-captain-america-hulk-the-incredible-hulk-illustration-comics-avengers-superhero-thumbnail.png"))
        superheroes.add(Superheroe("Captain America", "Marvel", "Steve Rogers", "https://i.pinimg.com/474x/2e/b3/3a/2eb33ac2dc6822d2f42745a4b8bccbf2.jpg"))
        superheroes.add(Superheroe("Wolverine", "Marvel", "James Howlett", "https://static.wikia.nocookie.net/featteca/images/8/82/Wolverine_PNG1.png/revision/latest?cb=20220219192157&path-prefix=es"))
        return superheroes
    }
}