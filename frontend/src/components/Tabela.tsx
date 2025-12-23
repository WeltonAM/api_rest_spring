"use client";
import Link from "next/link";
import { cn } from "@/utils/cn";
import { useProdutos } from "@/hooks";
import { IconeEdicao, IconeLixo, Tag } from "@/components";

export function Tabela() {
	const { produtos, excluir } = useProdutos();

	function CabecalhoTabela() {
		const colunas = [
			"id",
			"nome",
			"descricao",
			"categoria",
			"inseridoEm",
			"preco",
			"idUsuario",
		];

		return (
			<tr
				className={cn("text-centerbg-emerald-50", "border-b-2 border-gray-200")}
			>
				{colunas.map((coluna) => (
					<th key={coluna} className="p-4 text-emerald-700">
						{coluna.charAt(0).toUpperCase() + coluna.slice(1)}
					</th>
				))}
				<th className="p-4 text-emerald-700">Ações</th>
			</tr>
		);
	}

	function Linhas() {
		if (produtos.length === 0 || !produtos) return null;
		return produtos?.map((item: any, i) => (
			<tr
				key={i}
				className={cn(`text-center text-emerald-900`, {
					"border-b-2 rounded-xl border-gray-200": i != produtos.length - 1,
				})}
			>
				<td className="p-4">{item.id}</td>
				<td className="p-4 font-semibold">{item.nome}</td>
				<td className="p-4">{item.descricao}</td>
				<td className="p-4">
					<Tag texto={item.categoria} />
				</td>
				<td className="p-4">
					{new Date(item.inseridoEm).toLocaleDateString()}
				</td>
				<td className="p-4 text-emerald-500 font-semibold">
					R$ {item.preco.toFixed(2).replace(".", ",")}
				</td>
				<td className="p-4">{item.idUsuario}</td>
				<td>
					<div className="flex items-center justify-center">
						<button
							className={cn(
								"flex justify-center",
								"rounded-md p-2 m-1",
								"hover:bg-emerald-200 hover:text-emerald-800"
							)}
						>
							<Link href={`/produtos/${item.id}`}>
								<IconeEdicao width={18} />
							</Link>
						</button>

						<button
							onClick={() => {
								excluir(item.id);
							}}
							className={cn(
								"flex justify-center",
								"rounded-md p-2 m-1",
								"hover:bg-red-200 hover:text-red-800"
							)}
						>
							<IconeLixo width={18} />
						</button>
					</div>
				</td>
			</tr>
		));
	}

	if (!produtos || produtos.length === 0) {
		return (
			<div className="p-10 text-center text-emerald-900 font-semibold">
				Nenhum produto encontrado.
			</div>
		);
	}

	return (
		<div className={cn("flex flex-col", "rounded-xl border-2 border-gray-200")}>
			<table className="w-full overflow-hidden">
				<thead className="text-emerald-100 ">
					<CabecalhoTabela />
				</thead>
				<tbody>
					<Linhas />
				</tbody>
			</table>
		</div>
	);
}
