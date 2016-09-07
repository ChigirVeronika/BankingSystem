function addDishFormValidation(){
    var name = document.AddDish.name.value;
    var price = document.AddDish.price.value;
    var quantity = document.AddDish.quantity.value;
    var image = document.AddDish.image.value;
    var ingredients = document.AddDish.ingredients.value;
    var description = document.AddDish.description.value;

    if(dishNameValidation(name)){
        if(dishPriceValidation(price)){
            if(dishQuantityValidation(quantity)){
                if(dishImageValidation(image)){
                    if(dishIngredientsValidation(ingredients)){
                        if(dishDescriptionValidation(description)){
                            return true;
                        }
                    }
                }
            }
        }
    }
    return false;
}

function dishNameValidation(name){
    document.AddDish.name.focus();
    var letters = /^[0-9a-zA-ZА-Яа-я\-\s]+$/;
    if(value!=="") {
        if(value.length>1&&value.length<40){
            if(value.match(letters)){
                document.getElementById('dishName-msg').innerHTML="";
                return true;
            }
        }
    }
    document.getElementById('dishName-msg').innerHTML="Please, enter valid name";
    return false;
}

function dishPriceValidation(){
    document.AddDish.price.focus();
    var letters = /^[0-9]+\.[0-9]+$/;
    if(value!=="") {
        if(value.match(letters)){
            document.getElementById('dishPrice-msg').innerHTML="";
            return true;
        }
    }
    document.getElementById('dishPrice-msg').innerHTML="Please, enter valid price";
    return false;
}

function dishQuantityValidation(){
    document.AddDish.quantity.focus();
    var letters = /^[0-9]+$/;
    if(value!=="") {
        if(value.match(letters)){
            document.getElementById('dishQuantity-msg').innerHTML="";
            return true;
        }
    }
    document.getElementById('dishQuantity-msg').innerHTML="Please, enter valid quantity";
    return false;
}

function dishImageValidation(){
    document.AddDish.image.focus();
    var letters = /^[0-9a-zA-ZА-Яа-я\-]+\.[a-zA-Z]+$/;
    if(value!=="") {
        if(value.match(letters)){
            document.getElementById('dishImage-msg').innerHTML="";
            return true;
        }
    }
    document.getElementById('dishImage-msg').innerHTML="Please, enter valid omage url";
    return false;
}

function dishDescriptionValidation(value){
    document.AddDish.description.focus();
    if(value!=="") {
        document.getElementById('dishDescription-msg').innerHTML="";
        return true;
    }
    document.getElementById('dishDescription-msg').innerHTML="Please, enter valid description";
    return false;
}

function dishIngredientsValidation(value){
    document.AddDish.ingredients.focus();
    if(value!=="") {
        document.getElementById('dishIngredients-msg').innerHTML="";
        return true;
    }
    document.getElementById('dishIngredients-msg').innerHTML="Please, enter valid ingredients";
    return false;
}

