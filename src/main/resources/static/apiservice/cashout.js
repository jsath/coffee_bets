

const $ = selector => document.querySelector(selector); 

const newsByDate = "https://api.sportsdata.io/v3/nba/stats/json/BoxScore/";
const key = "key=0f0695cbcd434da582f5688d5897b7fe";


 
 
async function payDay(gameId){
    const response = await fetch(newsByDate + gameId + "?" + key);
    const data = await response.json();
    console.log(data);
    return check(data, gameId);
}


function check(data, gameId){
	if(data["Game"]["IsClosed"] == true){

		
		if(data["Game"]['HomeTeamScore'] != null){
			if(data["Game"]['HomeTeamScore'] > data['Game']['AwayTeamScore']){
			winner = data["Game"]['HomeTeam']
			}	else{
			winner = data["Game"]['AwayTeam']
		}	
		console.log(winner);
		document.getElementById(gameId).value = winner;
		document.getElementById('homeScore').value = data["Game"]['HomeTeamScore'];
		document.getElementById('awayScore').value = data['Game']['AwayTeamScore'];
		alert("Please verify data");
		console.log(document.getElementById(gameId).value)
	}
}
	else if(data["Game"]["Status"] == "Scheduled") {
		alert(`Game is scheduled for ${data["Game"]['DateTime']} UTC`);
	}else{
		return
	}
}
