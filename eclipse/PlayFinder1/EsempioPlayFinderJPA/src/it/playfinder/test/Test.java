package it.playfinder.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import it.playfinder.model.Evento;
import it.playfinder1.EntityFac;
import it.playfinder1.GestioneEvento;

public class Test {

	public static void main(String[] args) {
		if(e.squadraTrasferta.modulo != null){
			var gr = e.squadraTrasferta.modulo.giocatoriruolo;
			for(var i = 0, len = gr.length; i < len; i++){
				var gg = gr[i];
				var ruoliPartita = e.squadraTrasferta.ruoli.filter(r => r && r.ruolo.nome == gg.ruolo.nome);
				for(var x = 0, l = gg.nGiocatori; x < l; x++) {
					var nomeRuolo = '<p name="rp" id="'+gg.ruolo.nome+'">'+gg.ruolo.nome+'<button username = "'+u.username+'"idEvento="'+e.idEvento+'" idCasa ="'+ e.squadraTrasferta.idSquadra +'"idruolo="' + ruoliPartita[0].idRuoloPartita + '"class="btnS">' + 
					(ruoliPartita[0].users.length > x ? ruoliPartita[0].users[x].username : '?') + '</button></p>' ;
					$('#squadraTrasferta').append(nomeRuolo);
				}

			}

			$('.btnS').click(function(d){
				var event = {}
				event.rp = ($(this).attr("idruolo"));
				event.hdIdEvento = $(this).attr("idEvento")
				event.idCasa= $(this).attr("idCasa")
				event.username= $(this).attr("username")
				$.ajax({
					url: 'giocacasa',
					method: 'post',
					data : event,
				})
				});

		}
		}
}
