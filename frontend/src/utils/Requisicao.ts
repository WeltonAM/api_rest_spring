export class Requisicao {
	static headers: any = {
		"Content-Type": "application/json",
	};

	static urlBase: string = process.env.NEXT_PUBLIC_API_URL || "";

	static async requisicaoGenerica(
		metodo: string,
		complementoURL: string,
		dadosBody?: any
	) {
		if (complementoURL.startsWith("/")) {
			complementoURL = complementoURL.substring(1);
		}
		try {
			const dados = await fetch(Requisicao.urlBase + `${complementoURL}`, {
				method: metodo,
				headers: Requisicao.headers,
				body: JSON.stringify(dadosBody),
			});

			const resultado = await dados.json();

			console.log(resultado);

			if (resultado.mensagem) {
				throw new Error(resultado.mensagem);
			}

			if (resultado.error) {
				throw new Error(resultado.error);
			}

			return resultado;
		} catch (error: any) {
			const failedToFetch =
				error.message && error.message.includes("Failed to fetch");

			const naoTemMensagem = !error.message;

			if (failedToFetch || naoTemMensagem) {
				throw new Error("Houve um problema, tente novamente mais tarde.");
			}

			console.error(error);
			throw new Error(error.message);
		}
	}

	static async get(complementoURL: string) {
		const resultado = await Requisicao.requisicaoGenerica(
			"GET",
			complementoURL
		);
		return resultado;
	}

	static async post(complementoURL: string, dadosBody: any) {
		const resultado = await Requisicao.requisicaoGenerica(
			"POST",
			complementoURL,
			dadosBody
		);
		return resultado;
	}

	static async put(complementoURL: string, dadosBody: any) {
		const resultado = await Requisicao.requisicaoGenerica(
			"PUT",
			complementoURL,
			dadosBody
		);
		return resultado;
	}

	static async patch(complementoURL: string, dadosBody: any) {
		const resultado = await Requisicao.requisicaoGenerica(
			"PATCH",
			complementoURL,
			dadosBody
		);
		return resultado;
	}

	static async delete(complementoURL: string) {
		const resultado = await Requisicao.requisicaoGenerica(
			"DELETE",
			complementoURL
		);
		return resultado;
	}

	static adicionarToken(token: string) {
		Requisicao.headers["Authorization"] = `Bearer ${token}`;
	}

	static removerToken() {
		delete Requisicao.headers["Authorization"];
	}
}
