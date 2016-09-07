
function editCategoryFormValidation(){
    var name = document.EditCategory.name.value;
    var description = document.EditCategory.description.value;

    if(categoryNameOldValidation(name)){
        if(categoryDescriptionOldValidation(description)){
            return true;
        }
    }
    return false;
}

function categoryNameOldValidation(value){
    document.EditCategory.name.focus();
    var letters = /^[0-9a-zA-ZА-Яа-я\-\s]+$/;
    if(value!=="") {
        if(value.length>1&&value.length<40){
            if(value.match(letters)){
                document.getElementById('categoryNameOld-msg').innerHTML="";
                return true;
            }
        }
    }
    document.getElementById('categoryNameOld-msg').innerHTML="Please, enter valid category name";
    return false;
}

function categoryDescriptionOldValidation(value){
    document.EditCategory.description.focus();
    if(value!=="") {
        document.getElementById('categoryDescriptionOld-msg').innerHTML="";
        return true;
    }
    document.getElementById('categoryDescriptionOld-msg').innerHTML="Please, enter valid category description";
    return false;
}

function addCategoryFormValidation(){
    var name = document.AddCategory.name.value;
    var description = document.AddCategory.description.value;

    if(categoryNameValidation(name)){
        if(categoryDescriptionValidation(description)){
            return true;
        }
    }
    return false;
}

function categoryNameValidation(value){
    document.AddCategory.name.focus();
    var letters = /^[0-9a-zA-ZА-Яа-я\-\s]+$/;
    if(value!=="") {
        if(value.length>1&&value.length<40){
            //if(value.match(letters)){
                document.getElementById('categoryName-msg').innerHTML="";
                return true;
            //}
        }
    }
    document.getElementById('categoryName-msg').innerHTML="Please, enter valid category name";
    return false;
}

function categoryDescriptionValidation(value){
    document.AddCategory.description.focus();
    if(value!=="") {
        document.getElementById('categoryDescription-msg').innerHTML="";
        return true;
    }
    document.getElementById('categoryDescription-msg').innerHTML="Please, enter valid category description";
    return false;
}

