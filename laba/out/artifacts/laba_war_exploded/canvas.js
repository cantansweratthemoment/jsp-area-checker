const canvas = document.getElementById('canvas');
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("masloo").addEventListener("click", (e) => {
        let rr = document.getElementById("select");
        let r = rr.value;
        let maslo = document.getElementById('canvas');
        let event_x = e.pageX - maslo.offsetLeft;
        let event_y = e.pageY - maslo.offsetTop;
        let x = (event_x - 300) * r / 200;
        let y = (300 - event_y) * r / 200;
        post('controllerServlet', {X_f: x, Y_f: y, R_f: r});
    })
});
function post(path, params, method='post') {
    const form = document.createElement('form');
    form.method = method;
    form.action = path;
    for (const key in params) {
        if (params.hasOwnProperty(key)) {
            const hiddenField = document.createElement('input');
            hiddenField.type = 'hidden';
            hiddenField.name = key;
            hiddenField.value = params[key];

            form.appendChild(hiddenField);
        }
    }
    document.body.appendChild(form);
    form.submit();
}
function drawCanvas() {
    let canvas = document.getElementById("canvas"),
        context = canvas.getContext("2d");
    canvas.width = 500;
    canvas.height = 500;
    context.fillStyle = "E8D7FF";
    context.fillRect(150, 250, 100, 200);
    context.beginPath();
    context.moveTo(250, 250);
    context.lineTo(450, 250);
    context.lineTo(250, 450);
    context.fill();
    context.moveTo(250, 250);
    context.arc(250, 250, 200, Math.PI, Math.PI * 3 / 2);
    context.fill();
    context.beginPath();
    context.strokeStyle = "#FF47A0";
    context.lineWidth = 2;
    context.moveTo(0, 250);
    context.lineTo(500, 250);
    context.stroke();
    context.beginPath();
    context.strokeStyle = "#FF47A0";
    context.lineWidth = 2;
    context.moveTo(250, 500);
    context.lineTo(250, 0);
    context.stroke();
    context.strokeText("R/2", 350, 250);
    context.strokeText("R", 450, 250);
    context.strokeText("R/2", 250, 350);
    context.strokeText("R", 250, 450);
    context.strokeText("R/2", 150, 250);
    context.strokeText("R/2", 250, 150);
    context.strokeText("R", 250, 50);
    context.strokeText("R/2", 350, 250);
    context.strokeText("R", 50, 250);
    context.strokeText("Y", 250, 10);
    context.strokeText("X", 490, 250);
    drawPoints();
}

function drawPoint(x, y, result) {
    let canvas = document.getElementById("canvas"),
        context = canvas.getContext("2d");
    if (result === "false") {
        context.fillStyle = "#FF2A1F";
    } else {
        context.fillStyle = "#5FFF33";
    }
    context.beginPath();
    context.arc(x, y, 5, 0, 2 * Math.PI);
    context.fill();
    context.stroke();
    context.closePath();
}

function drawPoints() {
    let Xs = Array.from(document.getElementsByClassName("the_X")).map(v => v.innerHTML);
    let Ys = Array.from(document.getElementsByClassName("the_Y")).map(v => v.innerHTML);
    let Rs = Array.from(document.getElementsByClassName("the_R")).map(v => v.innerHTML);
    let Results = Array.from(document.getElementsByClassName("the_Result")).map(v => v.innerHTML);
    for (let i = 0; i < Xs.length; i++) {
        drawPoint(Xs[i] / Rs[i] * 400 / 2 + 250, Ys[i] / Rs[i] * (-400) / 2 + 250, Results[i]);
    }
}