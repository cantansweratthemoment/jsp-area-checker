let selectedCheckbox;
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("button").addEventListener("click", submit);
});

let submit = function (e) {
    if (!checkY()) {
        e.preventDefault();
    }
    if (!checkX()) {
        e.preventDefault();
        alert("Выберите X!")
    }
}

function checkY() {
    let y = document.getElementById("y");
    if (y.value.trim() === "") {
        alert("Y не должен быть пустым!");
        return false;
    } else if (!isFinite(y.value.replace(',', '.'))) {
        alert("Y должен быть числом!");
    } else if (y.value.replace(',', '.') >= 5 || y.value.replace(',', '.') <= -3) {
        alert("Y должен быть в диапазоне (-3; 5)");
        return false;
    } else {
        return true;
    }
}

function checkX() {
    return selectedCheckbox !== undefined;
}

function changeX(element) {
    if (element.checked) {
        if (selectedCheckbox !== undefined) {
            selectedCheckbox.checked = false;
        }
        selectedCheckbox = element;
    } else {
        selectedCheckbox = undefined;
    }
}