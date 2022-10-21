


const $ = selector => document.querySelector(selector); 

const newsByDate = "https://api.sportsdata.io/v3/nba/stats/json/BoxScore/";
const key = "key=f6386ba0dce143fe8681fe3ce97be569";






document.addEventListener("DOMContentLoaded", () => {
	
	let gameId = document.getElementById("gameapi").innerHTML;
	getData(gameId);


});


async function getData(gameId){
    const response = await fetch(newsByDate + gameId + "?" + key);
    const data = await response.json();
    return currentGame(data);
}


async function currentGame(data){
	$("#home").innerHTML = data["Game"]["HomeTeam"]
	$("#away").innerHTML = data["Game"]["AwayTeam"]
	$("#home").value = data["Game"]["HomeTeam"]
	$("#away").value = data["Game"]["AwayTeam"]
	
	content = '';
	content += "<div>";
	content += `<p>${data["Game"]["HomeTeam"]} vs ${data["Game"]["AwayTeam"]}</p>`;
	content += `<p>${data["Game"]["HomeTeam"]}: ${data["Game"]["HomeTeamMoneyLine"]} <br> ${data["Game"]["AwayTeam"]}: ${data["Game"]["AwayTeamMoneyLine"]}</p>`;
	if(data["Game"]["HomeTeamScore"] != null){
		content += `<p>${data["Game"]["HomeTeam"]} ${data["Game"]["HomeTeamScore"]} : ${data["Game"]["AwayTeam"]} ${data["Game"]["AwayTeamScore"]}</p>`;
	}
	content += "</div>"
	

	
	document.getElementById("gamedetails").innerHTML = content; 
	return;
}




async function calculatePayout(gameId){
	const response = await fetch(newsByDate + gameId + "?" + key);
    const data = await response.json();
	var amount = parseInt($("#amount").value);
	
	if($("#team").value == data["Game"]["HomeTeam"]){
		var moneyLine = data["Game"]["HomeTeamMoneyLine"]	
	}else if($("#team").value == data["Game"]["AwayTeam"]){
		var moneyLine = data["Game"]["AwayTeamMoneyLine"]
	}
	if(moneyLine <= 0){
		multi = (100/moneyLine);
		multi = Math.abs(multi)
	}else{
		multi = (moneyLine/100);
		multi = Math.abs(multi)
	}
	var stake = parseInt(amount * multi) + amount;
	
	$("#stake").value = stake;
}
