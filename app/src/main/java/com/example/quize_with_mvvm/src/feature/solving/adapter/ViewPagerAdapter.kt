package com.example.quize_with_mvvm.src.feature.solving.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quize_with_mvvm.R
import com.example.quize_with_mvvm.databinding.ItemSolvingVpager2QuestionBinding
import com.example.quize_with_mvvm.src.data.datasource.model.Quize
import com.example.quize_with_mvvm.src.data.datasource.model.User
import com.example.quize_with_mvvm.src.feature.result.ResultActivity


class ViewPagerAdapter(private val quizeList : ArrayList<Quize>, val user: User) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>()  {
    private var score = 0
    private var isCorrect = false

    interface OnItemClickListener{
        fun onItemClick(v : View, position : Int, isCorrect:Boolean)
    }

    private var listener : OnItemClickListener?=null

    fun setOnItemClickListener(listener:OnItemClickListener){
        this.listener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.ViewHolder {
        val binding = ItemSolvingVpager2QuestionBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.ViewHolder, position: Int) {
        holder.bind(quizeList[position])
    }

    override fun getItemCount(): Int = quizeList.size

    inner class ViewHolder(var binding : ItemSolvingVpager2QuestionBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data:Quize){
            binding.txTitle.text = data.title
            binding.imgQuize.setImageResource(data.img_question)
            binding.rdo1.text=data.choice1
            binding.rdo2.text=data.choice2
            binding.rdo3.text=data.choice3
            binding.rdo4.text=data.choice4

            if(adapterPosition==quizeList.size-1){
                binding.btnNext.text="결과 보기"
                binding.btnNext.setOnClickListener {
                    if(isCorrect)
                        score++
                    var intent = Intent(binding.root.context, ResultActivity::class.java)
                    user.score=score
                    intent.putExtra("User",user)
                    binding.root.context.startActivity(intent)
                }
            }else{
                binding.btnNext.setOnClickListener {
                    if(isCorrect)
                        score++
                    listener?.onItemClick(binding.root,position,isCorrect)
                }
            }

            binding.rGroup.setOnCheckedChangeListener { group, checkedId ->
                if(checkedId == R.id.rdo_1){
                    isCorrect = binding.rdo1.text==data.answer
                }else if(checkedId==R.id.rdo_2){
                    isCorrect = binding.rdo2.text==data.answer
                }else if(checkedId==R.id.rdo_3){
                    isCorrect = binding.rdo3.text==data.answer
                }else if(checkedId==R.id.rdo_4){
                    isCorrect = binding.rdo4.text==data.answer
                }
            }

        }
    }

}