const canvas = document.getElementById('canvas');
function drawCanvas(){
    let canvas = document.getElementById("canvas"),
        context = canvas.getContext("2d");
    canvas.width=500;
    canvas.height=500;
    context.fillStyle="E8D7FF";
    context.fillRect(150, 250, 100, 200);
    context.beginPath();
    context.moveTo(250,250);
    context.lineTo(450,250);
    context.lineTo(250,450);
    context.fill();
    context.moveTo(250,250);
    context.arc(250, 250, 200, Math.PI, Math.PI*3/2);
    context.fill();
    context.beginPath();
    context.strokeStyle="#FF47A0";
    context.lineWidth = 2;
    context.moveTo(0, 250);
    context.lineTo(500, 250);
    context.stroke();
    context.beginPath();
    context.strokeStyle="#FF47A0";
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
}
function canvasWasClicked(e){
    let x = e.pageX, y = e.pageY;
    let r = document.getElementById("select");
    if (r!==null){
    }
}