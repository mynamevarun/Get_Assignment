var empId = document.getElementById("fullName");
empId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        var title = document.getElementById("fullName").value;
        document.getElementById("nameDiv").innerHTML = "Hey " + title + " Can I know your details?";
        document.getElementById("emailDiv").style.display = "block";
    }
});

var emailId = document.getElementById("email");
emailId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("emailDiv").style.display = "none";
        document.getElementById("passwordDiv").style.display = "block";
    }
});

var passId = document.getElementById("password");
passId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("passwordDiv").style.display = "none";
        document.getElementById("confirmPassDiv").style.display = "block";
    }
});

var confirmId = document.getElementById("passwordTwo");
confirmId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("confirmPassDiv").style.display = "none";
        document.getElementById("contactNoDiv").style.display = "block";
    }
});

var contactId = document.getElementById("contactNo");
contactId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("contactNoDiv").style.display = "none";
        document.getElementById("genderDiv").style.display = "block";
    }
});

function submit() {
    document.getElementById("genderDiv").style.display = "none";
    document.getElementById("vehicleTypeDiv").style.display = "block";
}

function selectVehicle(value) {
    var vehicleType = value;
    document.getElementById("vehicleTypeDiv").style.display = "none";
    document.getElementById("vehicleNameDiv").style.display = "block";
}

var vehicleName = document.getElementById("vehicleName");
vehicleName.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("vehicleNameDiv").style.display = "none";
        document.getElementById("vehicleNumDiv").style.display = "block";
    }
});

var vehicleNum = document.getElementById("vehicleNum");
vehicleNum.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("vehicleNumDiv").style.display = "none";
        document.getElementById("empIdDiv").style.display = "block";
    }
});

var employeeId = document.getElementById("empId");
employeeId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("empIdDiv").style.display = "none";
        document.getElementById("identityDiv").style.display = "block";
    }
});

var identity = document.getElementById("identity");
identity.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("identityDiv").innerHTML = "Passes Price"
        var vehicleType = document.getElementById("typeSelect").value;
        document.getElementById(vehicleType).style.display = "block";
    }
});

function getPass(value) {
    var vehicleType = document.getElementById("typeSelect").value;
    document.getElementById(vehicleType).style.display = "none";
    document.getElementById("moneyTypeDiv").style.display = "block";
}

function convert(currency) {
    var vehicleType = document.getElementById("typeSelect").value;
    if (vehicleType == "car") {
        var amount = document.getElementById("carSelect").value;
    }
    if (vehicleType == "bike") {
        var amount = document.getElementById("bikeSelect").value;
    }
    if (vehicleType == "bus") {
        var amount = document.getElementById("busSelect").value;
    }

    if (currency == "inr") {
        finalAmount = amount;
    }
    if (currency == "usd") {
        finalAmount = amount * 0.013;
    }
    if (currency == "yen") {
        finalAmount = amount * 1.41;
    }
    document.getElementById("ticketPrice").style.display = "none";
    document.getElementById("ticketPrice").innerHTML = "Your Bill is " + finalAmount + currency;
    document.getElementById("btn").style.display = "block";
}

function generatePass() {
    document.getElementById("btn").style.display = "none";
    document.getElementById("ticketPrice").style.display = "block";
}